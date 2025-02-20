#!/bin/bash
dbUser="root"; 
dbHost="localhost";
dbPass="";
dbName="kingin";

dateRest="";

declare -a arr=(
    "usr"
    "fc"
    "po"
    "po_held_item"
    "po_know_move"
    "team"
    "team_mem_po"
);

restTbl() {
    /opt/lampp/bin/mysql -u ${dbUser} ${dbName} < $1.sql
}

main() {
    cd ${dateRest};
    for i in "${arr[@]}"
    do
        restTbl "${i}";
    done
}

main;
