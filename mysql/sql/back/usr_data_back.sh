#!/bin/bash
dbUser="root"; 
dbHost="localhost";
dbPass="";
dbName="kingin";

dateCur=$(date +"%Y%m%d%H%M%S");

declare -a arr=(
    "usr"
    "fc"
    "po"
    "po_held_item"
    "po_know_move"
    "team"
    "team_mem_po"
);

backTbl() {
    /opt/lampp/bin/mysqldump -u ${dbUser} -h ${dbHost} ${dbName} $1 > $1.sql
}

main() {
    mkdir ${dateCur};
    cd ${dateCur};
    for i in "${arr[@]}"
    do
        backTbl "${i}";
    done
}

main;
