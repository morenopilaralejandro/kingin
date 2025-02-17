drop table if exists aux_gear_foug_pd;
create temporary table aux_gear_foug_pd (
    gear_call_code varchar(32),
    pd_name varchar(32),
    lv int,
    ordr int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gear-foug-pd.csv'
into table aux_gear_foug_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gear_call_code,
pd_name,
lv,
ordr
);

delimiter &&
drop procedure if exists proc_insrt_gear_foug_pd;
create procedure proc_insrt_gear_foug_pd()
begin
	declare i int default 1;

    declare idGearCall int default 0;
    declare idPd int default 0;

    /*cur1 variables*/
    declare vGearCallCode varchar(32) default '';
    declare vPdName varchar(32) default '';
    declare vLv int default 0;
    declare vOrdr int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gear_foug_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gear_foug_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGearCallCode,
            vPdName,
            vLv,
            vOrdr;

        set idGearCall = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select gear_call_id into idGearCall 
                from gear_call 
                where gear_call_code = vGearCallCode;

            select pd_id into idPd 
                from pd 
                where pd_name_ja = vPdName;

            insert into gear_foug_pd (
                gear_call_id,
                pd_id,
                lv,
                ordr
            ) values (
                idGearCall,
                idPd,
                vLv,
                vOrdr
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gear_foug_pd;
end
&&
delimiter ;
call proc_insrt_gear_foug_pd();
