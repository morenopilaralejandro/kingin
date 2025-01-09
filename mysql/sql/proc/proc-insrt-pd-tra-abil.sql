drop table if exists aux_pd_tra_abil;
create temporary table aux_pd_tra_abil (
    pd_name varchar(32),
    abil_name varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-tra-abil.csv'
into table aux_pd_tra_abil 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
abil_name
);

delimiter &&
drop procedure if exists proc_insrt_pd_tra_abil;
create procedure proc_insrt_pd_tra_abil()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idAbil int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vAbilName varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_tra_abil;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_tra_abil;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vAbilName;

        set idAbil = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select abil_id into idAbil 
                from abil 
                where abil_name_en = vAbilName;

            insert into pd_tra_abil (
                pd_id,
                abil_id
            ) values (
                idPd,
                idAbil
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_tra_abil;
end
&&
delimiter ;
call proc_insrt_pd_tra_abil();
