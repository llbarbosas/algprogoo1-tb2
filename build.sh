#!/bin/bash

RED='\033[0;31m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
GREEN='\033[0;32m'
NC='\033[0m'

if [ -n "$1" ]
    then
        echo -e "${BLUE}Compilando ${CYAN}$1${NC}"
        find -name "*.java" | grep $1 > .sources
    else
        echo -e "${BLUE}Compilando projeto${NC}"
        find -name "*.java" > .sources
fi

javac -d bin @.sources