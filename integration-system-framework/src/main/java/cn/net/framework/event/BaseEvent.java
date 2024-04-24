package cn.net.framework.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @ClassName BaseEvent
 * @Description 时间基础类
 * @Author 叶丛林
 * @Date 2024/4/24 21:51
 * @Version 1.0
 */
public class BaseEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    private T data;
    private String operation;

    public BaseEvent(T data, String operation) {
        super(data);
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
     * 解析类型（在运行期可通过这个方法获取到真正的数据类型，避免了编译期的范型擦除）
     *
     * @return 解析类型
     */
    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getData()));
    }
}
