package com.cda.service.impl;

import com.cda.dao.ProductDao;
import com.cda.entity.Product;
import com.cda.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

/**
 * @description 商品信息业务逻辑
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Product selectById(Integer productId) {
        return productDao.selectById(productId);
    }

    @Override
    public Product selectByKey(String productNo) {
        return productDao.selectByKey(productNo);
    }

    @Override
    public Integer selectIdByKey(String productNo) {
        return productDao.selectIdByKey(productNo);
    }

    @Override
    public Integer selectCount() {
        return productDao.selectCount();
    }

    @Override
    public Boolean existsWithPrimaryKey(String productNo) {
        return productDao.existsWithPrimaryKey(productNo);
    }

    @Override
    public Boolean existsProductType(String productType) {
        return productDao.existsProductType(productType);
    }

    @Override
    public Boolean existsProductBrand(String productBrand) {
        return productDao.existsProductBrand(productBrand);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> selectAllSale() {
        return productDao.selectAllSale();
    }

    @Override
    public List<Map<String, Object>> selectAllByType() {
        return productDao.selectAllByType();
    }

    @Override
    public Boolean insertData(Product product) {
        product.setSaleTime(new Date());
        return productDao.insertData(product);
    }

    @Override
    public Boolean updateById(Product product) {
        return productDao.updateById(product);
    }

    @Override
    public Boolean deleteById(Integer productId) {
        return productDao.deleteById(productId);
    }


    @Override
    public List<Product> selectAllLikeName(String keyWord) {
        List<Product> products = new ArrayList<>();
        try {
            //从ES查询数据
            SearchRequest searchRequest = new SearchRequest("productsindex");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //查询条件
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(keyWord,"productName","productDescribe"));
            //高亮显示
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            HighlightBuilder.Field field1 = new HighlightBuilder.Field("productName");
            HighlightBuilder.Field field2 = new HighlightBuilder.Field("productDescribe");
            highlightBuilder.field(field1);
            highlightBuilder.field(field2);
            highlightBuilder.preTags("<label style = 'color:red'>");
            highlightBuilder.postTags("</label>");
            searchSourceBuilder.highlighter(highlightBuilder);
            searchRequest.source(searchSourceBuilder);
            //执行检索
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            //封装查询结果
            SearchHits hits = searchResponse.getHits();
            //获取总记录数
            long count = hits.getTotalHits().value;
            Iterator<SearchHit> iterator = hits.iterator();
            while (iterator.hasNext()){
                SearchHit searchHit = iterator.next();
                Product product = objectMapper.readValue(searchHit.getSourceAsString(), Product.class);
                //获取高亮字段
                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                //productName
                HighlightField highlightField = highlightFields.get("productName");
                if (highlightField!=null){
                    String highLightProductName = Arrays.toString(highlightField.fragments());
                    product.setProductName(highLightProductName);
                }
                //productDescribe
                HighlightField highlightField2 = highlightFields.get("productDescribe");
                if (highlightField2!=null){
                    String highLightProductDescribe = Arrays.toString(highlightField2.fragments());
                    product.setProductDescribe(highLightProductDescribe);
                }
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectAllLikeType(String keyWord) {
        return productDao.selectAllLikeType(keyWord);
    }

    @Override
    public List<Product> selectAllLikeBrand(String keyWord) {
        return productDao.selectAllLikeBrand(keyWord);
    }

    @Override
    public Map<String, Object> productOverview() {
        return productDao.productOverview();
    }
}
