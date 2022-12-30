/**
 * 列表单元
 *
 */

export class TList extends Array {
    constructor(ownsObjects = true) {
        super();
        /* 添加回调 */
        this._onAdded = null;
        /* 移除回调 */
        this._onRemoved = null;
        this.ownsObjectes = (ownsObjects == null ? true : ownsObjects);
    }
}