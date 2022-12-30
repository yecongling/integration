/**
 * 栈
 *
 */
export class TStack extends Array {
    constructor() {
        super();
    }

    /**
     * 出栈
     *
     * @returns {*}
     */
    peek() {
        return this[this.length - 1];
    }

    /**
     * 清空栈
     *
     */
    clear() {
        this.splice(0, this.length);
    }

    /**
     * 获取栈长度
     *
     * @returns {number}
     */
    get count() {
        return this.length;
    }
}