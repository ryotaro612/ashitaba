package main

import (
	"bytes"
	"strings"
	"testing"
)

func TestAcceptsPcFileInterpolatesPrefix(t *testing.T) {
	t.Parallel()
	s := strings.NewReader(`
prefix={{ .Prefix }}
includedir=${prefix}/include
libdir=${prefix}/lib64

Name: Webview
Description: Webview
Version: 0.12.0
Requires: gtk4, webkitgtk-6.0
Libs: -L${libdir} -lwebview
Cflags: -I${includedir}
`)

	b := bytes.NewBuffer(nil)
	if err := interpolate([]string{"-prefix", "/usr/local"}, s, b); err != nil {
		t.Errorf("failed to interpolate prefix: %#v", err)
	}

	if b.String() != `
prefix=/usr/local
includedir=${prefix}/include
libdir=${prefix}/lib64

Name: Webview
Description: Webview
Version: 0.12.0
Requires: gtk4, webkitgtk-6.0
Libs: -L${libdir} -lwebview
Cflags: -I${includedir}
` {
		t.Errorf("unexpected output: %#v", b.String())

	}
}
