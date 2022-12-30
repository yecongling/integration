/**
 *
 * 对象基类
 * 封装顶层对象
 *
 */

export class TObject {

    constructor() {
        this.createBefore();
        /* 基类对象名 */
        this._className = this.constructor.name;
    }

    /**
     * 对象创建前需要做的事
     */
    createBefore() {

    }

    /**
     * 数据处理
     */
    dispose() {

    }

    /**
     *  判断当前对象是否是给定的类型
     * @param cls 类型
     */
    isClass(cls) {
        return this instanceof cls;
    }

    /**
     * 判定当前对象是否是给定对象的子类
     *
     * @param cls 类型
     */
    isSubClass(cls) {
        if (cls === TObject) {
            return true;
        }
        let vObj = Object.getPrototypeOf(this);
        return vObj.isClass(cls);
    }

    /**
     * 创建一个实例
     */
    newInstance() {
        return new this.constructor
    }

    /**
     * 获取对象名
     *
     * @returns {*}
     * @constructor
     */
    get ClassName() {
        return this._className
    }
}