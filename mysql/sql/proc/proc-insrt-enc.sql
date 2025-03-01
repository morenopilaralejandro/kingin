drop table if exists aux_enc;
create temporary table aux_enc (
    enc_code varchar(32),
    enc_name_en varchar(32),	
    enc_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/enc.csv'
into table aux_enc 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
enc_code,
enc_name_en,	
enc_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_enc;
create procedure proc_insrt_enc()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vEncCode varchar(32) default '';
    declare vEncNameEn varchar(32) default '';
    declare vEncNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_enc;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from enc;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vEncCode, 
            vEncNameEn, 
            vEncNameJa;
        if continueCur1 = 1 then
            insert into enc (
                enc_code,
                enc_name_en,	
                enc_name_ja
            ) values (
                vEncCode,
                vEncNameEn,
                vEncNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_enc;
end
&&
delimiter ;
call proc_insrt_enc();
