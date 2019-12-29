package com.blog.frontend.common;

import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDTO {
    private List<PaperSimpleDTO> blogList;
    private List<PaperSimpleDTO> noteList;
}
