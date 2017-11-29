#!/bin/bash

echo "Line count of .java files found on this folder: "

echo ""
find . -type f \( -name "*.java" -o -name "*.xhtml" \) -exec wc -l {} + | cat

echo ""
read -n 1 -s -p "[Press any key to close]"