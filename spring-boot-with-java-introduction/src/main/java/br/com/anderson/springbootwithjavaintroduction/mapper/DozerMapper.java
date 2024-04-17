package br.com.anderson.springbootwithjavaintroduction.mapper;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.sun.codemodel.JForEach;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); // Create dozzer construct

    public static <O, D> D parseObject(O origin, Class<D> destiny){
        return mapper.map(origin, destiny);
    }

    public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destiny){
        List<D> destinyList = new ArrayList<>();
        for(O o : origin){
            destinyList.add(mapper.map(o, destiny));
        }
        return destinyList;
    }
}
