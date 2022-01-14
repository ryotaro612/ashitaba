include_directories(${PROJECT_SOURCE_DIR}/src)
include(GoogleTest)

add_executable(testam1 am1.cc)
target_link_libraries(testam1 am1 gtest_main)
gtest_discover_tests(testam1)

add_executable(testam2 am2.cc)
target_link_libraries(testam2 am2 gtest_main)
gtest_discover_tests(testam2)

