drop table if exists aux_replace;
create temporary table aux_replace (
    column1 varchar(32),
    column2 int,
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/replace.csv'
into table aux_replace 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
columns
);

delimiter &&
drop procedure if exists proc_insrt_replace;
create procedure proc_insrt_replace()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare v varchar(32) default '';
    declare v int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_replace;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from replace;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into v;
        if continueCur1 = 1 then
            /*TODO*/
            insert into replace (

            ) values (

            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_replace;
end
&&
delimiter ;
call proc_insrt_replace();
