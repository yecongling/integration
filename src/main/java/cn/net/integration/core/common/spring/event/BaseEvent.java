package cn.net.integration.core.common.spring.event;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @ClassName BaseEvent
 * @Description 事件基类
 * @Author ycl
 * @Date 2024/1/22 14:58
 * @Version 1.0
 */
public class BaseEvent<T> implements ResolvableTypeProvider {

    private T data;
    private String operation;

    public BaseEvent(T data, String operation) {
        this.data = data;
        this.operation = operation;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * @return 解析类型（在运行期可通过这个方法获取到真正的数据类型，避免了编译期的范型擦除）
     */
    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getData()));
    }
}
