##@ Build
build/webview_src/.git/HEAD:
	mkdir -p build && \
	cd build && \
	git clone --depth=1 --branch=0.12.0 git@github.com:webview/webview.git webview_src

build/webview/include/webview/webview.h: build/webview_src/.git/HEAD
	cd build/webview_src && \
	rm -rf build && \
	cmake -G Ninja -B build -S . -D CMAKE_INSTALL_PREFIX=../webview -D CMAKE_BUILD_TYPE=Release -D WEBVIEW_BUILD_DOCS=off && \
	cd build && \
	ninja install

##@ Test
test: ## Run tests.
	go test ./...

##@ Clean
clean:
	rm -rf build


##@ Help
help: ## Display this help.
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_0-9-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help

.PHONY: test clean help


## g++  -std=c++17 -Wall -Wextra  main.c $(PKG_CONFIG_PATH="." pkg-config --cflags --libs webview )
