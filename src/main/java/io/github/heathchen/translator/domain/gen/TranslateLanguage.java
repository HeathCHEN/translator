package io.github.heathchen.translator.domain.gen;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName translate_language
 */
@TableName(value = "translate_language")
@Data
public class TranslateLanguage implements Serializable {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 语言名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 中文名称
     */
    @TableField(value = "zh_name")
    private String zhName;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;


}
