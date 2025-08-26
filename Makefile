##@ Build
build/webview/.git/HEAD:
	git clone --depth=1 --branch=0.12.0 git@github.com:webview/webview.git

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