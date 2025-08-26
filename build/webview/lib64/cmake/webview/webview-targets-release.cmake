#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "webview::core_shared" for configuration "Release"
set_property(TARGET webview::core_shared APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(webview::core_shared PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib64/libwebview.so.0.12.0"
  IMPORTED_SONAME_RELEASE "libwebview.so.0.12"
  )

list(APPEND _cmake_import_check_targets webview::core_shared )
list(APPEND _cmake_import_check_files_for_webview::core_shared "${_IMPORT_PREFIX}/lib64/libwebview.so.0.12.0" )

# Import target "webview::core_static" for configuration "Release"
set_property(TARGET webview::core_static APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(webview::core_static PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_RELEASE "CXX"
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib64/libwebview.a"
  )

list(APPEND _cmake_import_check_targets webview::core_static )
list(APPEND _cmake_import_check_files_for_webview::core_static "${_IMPORT_PREFIX}/lib64/libwebview.a" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
