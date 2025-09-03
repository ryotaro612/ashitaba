package main

import (
	"context"
	"flag"
	"io"
	"log/slog"
	"os"
	"text/template"

	"github.com/ryotaro612/ashitaba/internal"
)

func main() {

	//interpolate(os.Stdin, os.Stdout)
	// ctx := context.Background()
	// logger := internal.NewTextLogger(os.Stderr, slog.LevelDebug)

	// fs := flag.NewFlagSet("pc", flag.ContinueOnError)

	// prefix := fs.String("prefix", "", "path to the directory that contains include and lib64 of webview")

	// // path := "cmd/webview.pc.template"
	// var err error
	// defer func() {
	// 	if err != nil {
	// 		logger.ErrorContext(ctx, "failed to generate a package config file", "error", err)
	// 		os.Exit(1)
	// 	}
	// }()

	// if err = fs.Parse(os.Args[1:]); err != nil {
	// 	return
	// }

	// bs, err := io.ReadAll(os.Stdin)
	// txt := string(bs)
	// a := struct{ Prefix string }{
	// 	Prefix: "foobar",
	// }
	// t, err := template.New("pc").Parse(txt)
	// t.Execute(os.Stdout, a)
	// interpolate(os.Stdin, os.Stdout)
}

func interpolate(args []string, in io.Reader, out io.Writer) error {
	l := internal.NewTextLogger(os.Stderr, slog.LevelDebug)
	ctx := context.Background()

	bs, err := io.ReadAll(in)
	if err != nil {
		l.ErrorContext(ctx, "failed to read input", "error", err)
		return err
	}
	txt := string(bs)
	t, err := template.New("pc").Parse(txt)
	if err != nil {
		l.ErrorContext(ctx, "failed to parse template text", "error", err)
		return err
	}

	fs := flag.NewFlagSet("pc", flag.ContinueOnError)
	prefix := fs.String("prefix", "", "path to the directory that contains include and lib64 of webview")
	fs.Parse(args)
	a := struct{ Prefix string }{
		Prefix: *prefix,
	}
	return t.Execute(out, a)
}

// // NewTextLogger
// func NewTextLogger(level slog.Level) *slog.Logger {
// 	logger := slog.New(slog.NewTextHandler(os.Stdout, &slog.HandlerOptions{
// 		Level: level,
// 	}))
// 	return logger
// }
