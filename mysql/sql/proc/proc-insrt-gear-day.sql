drop table if exists aux_gear_day;
create temporary table aux_gear_day (
    gear_day_code varchar(32),
    gear_day_name_en varchar(32),	
    gear_day_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gear-day.csv'
into table aux_gear_day 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gear_day_code,
gear_day_name_en,	
gear_day_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_gear_day;
create procedure proc_insrt_gear_day()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vGearDayCode varchar(32) default '';
    declare vGearDayNameEn varchar(32) default '';
    declare vGearDayNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gear_day;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gear_day;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGearDayCode, 
            vGearDayNameEn, 
            vGearDayNameJa;
        if continueCur1 = 1 then
            insert into gear_day (
                gear_day_code,
                gear_day_name_en,	
                gear_day_name_ja
            ) values (
                vGearDayCode,
                vGearDayNameEn,
                vGearDayNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gear_day;
end
&&
delimiter ;
call proc_insrt_gear_day();
