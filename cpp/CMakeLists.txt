# cmake_minimum_required(VERSION <specify CMake version here>)
project(cpp)

set(CMAKE_CXX_STANDARD 14)

if(WIN)
    set(CMAKE_LEGACY_CYGWIN_WIN32 0)
endif()

add_executable(Solution1 leetcode200_299/Solution206.cpp)