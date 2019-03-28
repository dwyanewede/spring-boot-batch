package com.sxs.spring.boot.batch.Item;

import com.sxs.spring.boot.batch.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @ClassName: PrintWriterItem
 * @Description: 数据输出item
 * @Author: 尚先生
 * @CreateDate: 2019/3/15
 * @Version: 1.0
 */
public class PrintWriterItem<T> implements ItemWriter<T> {

    Logger logger = LoggerFactory.getLogger(MyProcessorItem.class);
    @Override
    public void write(List<? extends T> list) throws Exception {
        list.stream().forEach(a->{
            Article article=(Article)a;
            logger.info("[{}] PrintWriterItem 处理器",article.getTitle());
        });

    }
}
