/*
\! clear
source /home/alejandro/eclipse-workspace/kingin/mysql/sql/kingin.sql;
*/

drop database kingin;
create database kingin;
use kingin;

source ~/eclipse-workspace/kingin/mysql/sql/script/script-drp.sql;
source ~/eclipse-workspace/kingin/mysql/sql/script/script-crt.sql;
/*
source ~/eclipse-workspace/kingin/mysql/sql/script/script-insrt.sql;
*/
