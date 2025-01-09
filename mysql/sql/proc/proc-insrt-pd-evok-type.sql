drop table if exists aux_pd_evok_type;
create temporary table aux_pd_evok_type (
    pd_name varchar(32),
    type_name varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-evok-type.csv'
into table aux_pd_evok_type 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_name,
type_name
);

delimiter &&
drop procedure if exists proc_insrt_pd_evok_type;
create procedure proc_insrt_pd_evok_type()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idType int default 0;

    /*cur1 variables*/
    declare vPdName varchar(32) default '';
    declare vTypeName varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_evok_type;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_evok_type;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdName,
            vTypeName;

        set idType = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            select type_id into idType 
                from type 
                where type_name_en = vTypeName;

            insert into pd_evok_type (
                pd_id,
                type_id
            ) values (
                idPd,
                idType
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_evok_type;
end
&&
delimiter ;
call proc_insrt_pd_evok_type();
