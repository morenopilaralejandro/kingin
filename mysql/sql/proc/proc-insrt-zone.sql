drop table if exists aux_zone;
create temporary table aux_zone (
    zone_code varchar(32),
    zone_name_code varchar(32),
    zone_main_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/zone.csv'
into table aux_zone 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone_code,
zone_name_code,
zone_main_code
);

delimiter &&
drop procedure if exists proc_insrt_zone;
create procedure proc_insrt_zone()
begin
	declare i int default 1;

    declare idZoneName int default 0;
    declare idZoneMain int default 0;

    /*cur1 variables*/
    declare vZoneCode varchar(32) default '';
    declare vZoneNameCode varchar(32) default '';
    declare vZoneMainCode varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_zone;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from zone;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZoneCode, 
            vZoneNameCode,
            vZoneMainCode;

        set idZoneName = 0;
        set idZoneMain = 0;

        if continueCur1 = 1 then
            if vZoneNameCode = '' then
                set idZoneName = null;
            else
                select zone_name_id into idZoneName
                    from zone_name
                    where zone_name_code = vZoneNameCode;
            end if; 

            if vZoneMainCode = '' then
                set idZoneMain = null;
            else
                select zone_id into idZoneMain
                    from zone
                    where zone_code = vZoneMainCode;
            end if; 

            insert into zone (
                zone_code, 
                zone_name_id,
                zone_main_id
            ) values (
                vZoneCode, 
                idZoneName,
                idZoneMain
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_zone;
end
&&
delimiter ;
call proc_insrt_zone();
