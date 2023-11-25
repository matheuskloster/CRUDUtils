package com.kloster.mapper;

import com.kloster.entity.MyEntity;
import com.kloster.model.MyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring", imports = {MyModel.class, MyEntity.class})
public interface MyMapper {

    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

    @Mapping(source= "id", target = "id")
    @Mapping(source= "nome", target = "nome")
    @Mapping(source= "idade", target = "idade")
    MyEntity toMyEntity(MyModel myModel);

    @Mapping(source= "id", target = "id")
    @Mapping(source= "nome", target = "nome")
    @Mapping(source= "idade", target = "idade")
    MyModel toMyModel(MyEntity myEntity);

    List<MyModel> toMyModelList(List<MyEntity> myEntityList);

}
