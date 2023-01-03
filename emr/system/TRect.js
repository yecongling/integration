/**
 * 矩形区域
 *
 */

export class TRect{
    /* 1283 */
    constructor() {
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
    }

    /**
     * 静态方法 创建矩形区域
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @constructor
     */
    static Create(left, top, right, bottom) {
        let rect = new TRect();
        rect.left = left;
        rect.top = top;
        rect.right = right;
        rect.bottom = bottom;
        return rect;
    }

    /**
     * 静态方法  根据给定的rect创建
     *
     * @param rect
     * @constructor
     */
    static CreateByRect(rect) {
        return this.Create(rect.left, rect.top, rect.right, rect.bottom);
    }

    /**
     * 静态方法  创建矩形
     *
     * @param left
     * @param top
     * @param width
     * @param height
     * @constructor
     */
    static CreateByBounds(left, top, width, height) {
        let rect = new TRect();
        rect.left = left;
        rect.top = top;
        rect.right = left + width;
        rect.bottom = top + height;
        return rect;
    }

    /**
     * 重置位置
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    reset(left, top, right, bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /**
     * 根据给定的rect重置
     *
     * @param rect
     */
    resetRect(rect) {
        this.reset(rect.left, rect.top, rect.right, rect.bottom);
    }

}