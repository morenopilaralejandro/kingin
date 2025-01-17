drop table if exists aux_pd_dimo_gndr;
create temporary table aux_pd_dimo_gndr (
    pd_name varchar(32),
    gndr_code varchar(32),
    rate int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-dimo-gndr.csv'
into table aux_pd_dimo_gndr 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
gndr_code,
rate
);

delimiter &&
drop procedure if exists proc_insrt_pd_dimo_gndr;
create procedure proc_insrt_pd_dimo_gndr()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idGndr int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vGndrCode varchar(32) default '';
    declare vRate int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_dimo_gndr;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_dimo_gndr;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vGndrCode;

        set idGndr = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select gndr_id into idGndr 
                from gndr 
                where gndr_code = vGndrCode;

            insert into pd_dimo_gndr (
                pd_id,
                gndr_id,
                rate
            ) values (
                idPd,
                idGndr,
                vRate
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_dimo_gndr;
end
&&
delimiter ;
call proc_insrt_pd_dimo_gndr();
