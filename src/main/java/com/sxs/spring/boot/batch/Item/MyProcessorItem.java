package com.sxs.spring.boot.batch.Item;
import com.sxs.spring.boot.batch.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyProcessorItem
 * @Description: 数据处理Item
 * @Author: 尚先生
 * @CreateDate: 2019/3/15
 * @Version: 1.0
 */
@Service
public class MyProcessorItem implements ItemProcessor<Article,Article> {

    Logger logger = LoggerFactory.getLogger(MyProcessorItem.class);

    @Override
    public Article process(Article article)throws Exception{
       logger.info("[{}] MyProcessorItem 处理器",article.getTitle());
        return article;
    }
}
