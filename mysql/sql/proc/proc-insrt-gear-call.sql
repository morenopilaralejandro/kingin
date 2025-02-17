drop table if exists aux_gear_call;
create temporary table aux_gear_call (
    gear_call_code varchar(32),
    gear_day varchar(32),
    gear_time varchar(32),
    npc varchar(32),
    zone varchar(32),
    money int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gear-call.csv'
into table aux_gear_call 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gear_call_code,
gear_day,
gear_time,
npc,
zone,
money
);

delimiter &&
drop procedure if exists proc_insrt_gear_call;
create procedure proc_insrt_gear_call()
begin
	declare i int default 1;

    declare idGearDay int default 0;
    declare idGearTime int default 0;
    declare idNpc int default 0;
    declare idZone int default 0;

    /*cur1 variables*/
    declare vGearCallCode varchar(32) default '';
    declare vGearDay varchar(32) default '';
    declare vGearTime varchar(32) default '';
    declare vNpc varchar(32) default '';
    declare vZone varchar(32) default '';
    declare vMoney int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gear_call;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gear_call;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGearCallCode, 
            vGearDay,
            vGearTime,
            vNpc,
            vZone,
            vMoney;

        set idGearDay = 0;
        set idGearTime = 0;
        set idNpc = 0;
        set idZone = 0;

        if continueCur1 = 1 then
            select gear_day_id into idGearDay
                from gear_day
                where gear_day_code = vGearDay;

            select gear_time_id into idGearTime
                from gear_time
                where gear_time_code = vGearTime;

            select npc_id into idNpc
                from npc 
                where npc_code = vNpc;

            select zone_id into idZone
                from zone
                where zone_code = vZone;

            insert into gear_call (
                gear_call_code,
                gear_day_id,
                gear_time_id,
                npc_id,    
                zone_id,
                money
            ) values (
                vGearCallCode,
                idGearDay,
                idGearTime,
                idNpc,
                idZone,
                vMoney
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gear_call;
end
&&
delimiter ;
call proc_insrt_gear_call();
