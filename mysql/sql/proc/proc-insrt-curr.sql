drop table if exists aux_curr;
create temporary table aux_curr (
    curr_code varchar(32),
    curr_name_en varchar(32),	
    curr_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/curr.csv'
into table aux_curr 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
curr_code,
curr_name_en,	
curr_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_curr;
create procedure proc_insrt_curr()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vCurrCode varchar(32) default '';
    declare vCurrNameEn varchar(32) default '';
    declare vCurrNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_curr;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from curr;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vCurrCode, 
            vCurrNameEn, 
            vCurrNameJa;
        if continueCur1 = 1 then
            /*TODO*/
            insert into curr (
                curr_code,
                curr_name_en,	
                curr_name_ja
            ) values (
                vCurrCode,
                vCurrNameEn,
                vCurrNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_curr;
end
&&
delimiter ;
call proc_insrt_curr();
