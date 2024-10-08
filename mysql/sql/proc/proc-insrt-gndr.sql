drop table if exists aux_gndr;
create temporary table aux_gndr (
    gndr_code varchar(32),
    gndr_name_en varchar(32),
    gndr_name_ja varchar(32),
    gndr_sym varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/gndr.csv'
into table aux_gndr 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
gndr_code,
gndr_name_en,
gndr_name_ja,
gndr_sym
);

delimiter &&
drop procedure if exists proc_insrt_gndr;
create procedure proc_insrt_gndr()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vGndrCode varchar(32) default '';
    declare vGndrNameEn varchar(32) default '';
    declare vGndrNameJa varchar(32) default '';
    declare vGndrSym varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_gndr;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from gndr;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vGndrCode,
            vGndrNameEn,
            vGndrNameJa,
            vGndrSym;

        if continueCur1 = 1 then
            insert into gndr (
                gndr_code,
                gndr_name_en,
                gndr_name_ja,
                gndr_sym
            ) values (
                vGndrCode,
                vGndrNameEn,
                vGndrNameJa,
                vGndrSym
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_gndr;
end
&&
delimiter ;
call proc_insrt_gndr();
