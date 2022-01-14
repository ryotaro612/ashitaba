cmake_minimum_required(VERSION 3.16.3)
project(lc)
set(CMAKE_CXX_FLAGS "-std=c++17 -Wextra -Wall -ftrapv")

option(CMAKE_EXPORT_COMPILE_COMMANDS 1)
option(CMAKE_BUILD_TYPE Debug)

include(FetchContent)
FetchContent_Declare(
  googletest
  # Specify the commit you depend on and update it regularly.
  URL https://github.com/google/googletest/archive/refs/tags/release-1.11.0.zip
)
# For Windows: Prevent overriding the parent project's compiler/linker settings
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)
FetchContent_MakeAvailable(googletest)
include(GoogleTest)
enable_testing()
add_subdirectory(src)
add_subdirectory(tests)

