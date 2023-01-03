/**
 * 列表单元
 *
 */
import {TObject} from "./TObject";

export class TList extends Array {
    constructor(ownsObjects = true) {
        super();
        /* 添加回调 */
        this._onAdded = null;
        /* 移除回调 */
        this._onRemoved = null;
        this.ownsObjectes = (ownsObjects == null ? true : ownsObjects);
    }

    /**
     * 添加一个条目
     *
     * @param item
     * @private
     */
    doAdded_(item) {
        if (this._onAdded != null) {
            this._onAdded(item);
        }
    }

    /**
     * 移除一个条目
     *
     * @param item
     * @private
     */
    doRemoved_(item) {
        if (this._onRemoved != null) {
            this._onRemoved(item);
        }
        if (this.ownsObjectes) {
            let vObj = Object.getPrototypeOf(item);
            if (vObj instanceof TObject) {
                vObj.dispose();
            }
        }
    }

    /**
     * 清空
     *
     * @private
     */
    doClear_() {

    }

    /**
     * 添加一个item
     *
     * @param item
     */
    add(item) {
        this[this.length] = item;
        this.doAdded_(item);
    }

    /**
     * 索引位置
     *
     * @param item
     */
    indexOf(item) {
        for (let i = 0; i < this.length; i++) {
            if (this[i] === item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 移除指定位置
     *
     * @param index
     */
    removeAt(index) {
        if (index >= 0) {
            let vItem = this[index];
            this.splice(index, 1);
            this.doRemoved_(vItem);
            vItem = null;
            return true;
        }

        return false;
    }

    /**
     * 移除指定条目
     *
     * @param item
     */
    remove(item) {
        return this.removeAt(this.indexOf(item));
    }

    /**
     * 移除一定范围的item
     *
     * @param index
     * @param count
     */
    removeRange(index, count) {
        if (index >= 0) {
            let vItem = null;
            let vObj;
            for (let i = index; i < index + count; i++) {
                vItem = this[i];
                this.doRemoved_(vItem);
                vObj = Object.getPrototypeOf(vItem);
                if (vObj instanceof TObject) {
                    vItem.dispose();
                }
                vItem = null;
            }

            this.splice(index, count);
            return true;
        }
        return false;
    }

}