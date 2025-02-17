drop table if exists aux_gear_time;
create temporary table aux_gear_time (
    gear_time_code varchar(32),
    gear_time_name_en varchar(32),	
    gear_time_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gear-time.csv'
into table aux_gear_time 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gear_time_code,
gear_time_name_en,	
gear_time_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_gear_time;
create procedure proc_insrt_gear_time()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vGearTimeCode varchar(32) default '';
    declare vGearTimeNameEn varchar(32) default '';
    declare vGearTimeNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gear_time;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gear_time;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGearTimeCode, 
            vGearTimeNameEn, 
            vGearTimeNameJa;
        if continueCur1 = 1 then
            insert into gear_time (
                gear_time_code,
                gear_time_name_en,	
                gear_time_name_ja
            ) values (
                vGearTimeCode,
                vGearTimeNameEn,
                vGearTimeNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gear_time;
end
&&
delimiter ;
call proc_insrt_gear_time();
