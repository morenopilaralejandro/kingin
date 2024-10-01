drop table if exists aux_type;
create temporary table aux_type (
    type_code varchar(32),
    type_name_en varchar(32),
    type_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/type.csv'
into table aux_type 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(type_code, type_name_en, type_name_ja);

delimiter &&
drop procedure if exists proc_insrt_type;
create procedure proc_insrt_type()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vTypeCode varchar(32) default '';
    declare vTypeNameEn varchar(32) default '';
    declare vTypeNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_type;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from type;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vTypeCode, 
            vTypeNameEn, 
            vTypeNameJa;

        if continueCur1 = 1 then
            insert into type (
                type_code, 
                type_name_en, 
                type_name_ja
            ) values (
                vTypeCode, 
                vTypeNameEn, 
                vTypeNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_type;
end
&&
delimiter ;
call proc_insrt_type();
