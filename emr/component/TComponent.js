/**
 * 常用组件基类
 *
 */
import {TPersistent} from "./TPersistent";
import {TList} from "../system/TList";

export class TComponent extends TPersistent {
    constructor() {
        super();
        this.publishProperty = new TList();
    }

    /**
     * 添加属性
     *
     * @param propClass
     */
    addPublishProperty(propClass) {
        this.publishProperty.add(propClass);
    }
}