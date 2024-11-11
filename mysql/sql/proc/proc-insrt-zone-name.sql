drop table if exists aux_zone;
create temporary table aux_zone (
    zone_name_code varchar(32),
    zone_name_en varchar(1000),
    zone_name_ja varchar(1000)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/zone-name.csv'
into table aux_zone 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone_name_code,
zone_name_en,
zone_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_zone;
create procedure proc_insrt_zone()
begin
	declare i int default 1;

    declare idZoneMain int default 0;

    /*cur1 variables*/
    declare vZoneNameCode varchar(32) default '';
    declare vZoneNameEn varchar(1000) default '';
    declare vZoneNameJa varchar(1000) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_zone;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from zone;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZoneNameCode,
            vZoneNameEn,
            vZoneNameJa;
 
        if continueCur1 = 1 then
            insert into zone_name (
                zone_name_code,
                zone_name_en,
                zone_name_ja
            ) values (
                vZoneNameCode, 
                vZoneNameEn, 
                vZoneNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_zone;
end
&&
delimiter ;
call proc_insrt_zone();
