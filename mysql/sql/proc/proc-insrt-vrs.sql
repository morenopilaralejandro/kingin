drop table if exists aux_vrs;
create temporary table aux_vrs (
    vrs_code varchar(32),
    vrs_name_en varchar(32),	
    vrs_name_ja varchar(32),
    vrs_sym varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/vrs.csv'
into table aux_vrs 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
vrs_code,
vrs_name_en,	
vrs_name_ja,
vrs_sym
);

delimiter &&
drop procedure if exists proc_insrt_vrs;
create procedure proc_insrt_vrs()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vVrsCode varchar(32) default '';
    declare vVrsNameEn varchar(32) default '';
    declare vVrsNameJa varchar(32) default '';
    declare vVrsSym varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_vrs;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from vrs;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vVrsCode, 
            vVrsNameEn, 
            vVrsNameJa,
            vVrsSym;
        if continueCur1 = 1 then
            insert into vrs (
                vrs_code,
                vrs_name_en,	
                vrs_name_ja,
                vrs_sym
            ) values (
                vVrsCode,
                vVrsNameEn,
                vVrsNameJa,
                vVrsSym
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_vrs;
end
&&
delimiter ;
call proc_insrt_vrs();
