drop table if exists aux_stat;
create temporary table aux_stat (
    stat_code varchar(32),
    stat_name_en varchar(32),
    stat_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/stat.csv'
into table aux_stat 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
stat_code,
stat_name_en,
stat_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_stat;
create procedure proc_insrt_stat()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vStatCode varchar(32) default '';
    declare vStatNameEn varchar(32) default '';
    declare vStatNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_stat;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from stat;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vStatCode,
            vStatNameEn,
            vStatNameJa;

        if continueCur1 = 1 then
            insert into stat (
                stat_code,
                stat_name_en,
                stat_name_ja
            ) values (
                vStatCode,
                vStatNameEn,
                vStatNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_stat;
end
&&
delimiter ;
call proc_insrt_stat();
