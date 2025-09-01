package main

// #cgo pkg-config: webview
// #include <stdlib.h>
// #include "webview/webview.h"
import (
	"C"
)
import (
	"runtime"
	"unsafe"
)

func init() {
	// Ensure that main.main is called from the main thread
	runtime.LockOSThread()
}

func MakeWebview() Webview {
	w := C.webview_create(0, nil)

	return Webview{w: &w}
}

func (w Webview) SetTitle(s string) {
	title := C.CString(s)
	defer C.free(unsafe.Pointer(title))
	C.webview_set_title(*w.w, title)
}

func (w Webview) SetHtml(s string) {
	html := C.CString(s)
	defer C.free(unsafe.Pointer(html))
	C.webview_set_html(*w.w, html)
}

func (w Webview) Run() {
	C.webview_run(*w.w)
}

func (w Webview) SetSize(width int, height int) {

	C.webview_set_size(*w.w, C.int(width), C.int(height), C.WEBVIEW_HINT_NONE)
}

// Hints are used to configure window sizing and resizing
type Hint int

const (
	// Width and height are default size
	HintNone = C.WEBVIEW_HINT_NONE

	// Window size can not be changed by a user
	HintFixed = C.WEBVIEW_HINT_FIXED

	// Width and height are minimum bounds
	HintMin = C.WEBVIEW_HINT_MIN

	// Width and height are maximum bounds
	HintMax = C.WEBVIEW_HINT_MAX
)

type Webview struct {
	w *C.webview_t
}

func main() {
	w := MakeWebview()
	w.SetTitle("Hello")
	w.SetSize(800, 600)
	w.SetHtml("<h1>Hello, World!</h1>")
	w.Run()
}
