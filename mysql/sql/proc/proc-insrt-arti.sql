delimiter &&
drop procedure if exists proc_insrt_arti;
create procedure proc_insrt_arti()
begin
	declare i int default 1;
    
    insert into arti_type (
        arti_type_id,
        arti_type_code,
        arti_type_name_en,
        arti_type_name_ja
    ) values 
    (1, 'guide', 'Guides', 'ガイド'),
    (2, 'news', 'News', 'ニュース');

    insert into arti (
        arti_id,
        arti_code,
        arti_name_en,
        arti_name_ja,
        arti_view,
        arti_type_id
    ) values
    (1, 'test', 'en', 'ja', 0, 1);
end
&&
delimiter ;
call proc_insrt_arti();
