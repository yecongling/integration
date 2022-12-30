/**
 * 点控制单元 包含 x、y
 *
 */
export class TPoint {
    /* 1206 */
    constructor() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * 创建点
     *
     * @param x x位置
     * @param y y位置
     * @constructor
     */
    static Create(x, y) {
        let point = new TPoint();
        point.x = x;
        point.y = y;
        return point;
    }

    /**
     * 创建指定点
     *
     * @param pt TPoint
     * @constructor
     */
    static CreateByPoint(pt) {
        return TPoint.Create(pt.x, pt.y);
    }

    /**
     * 重置点
     *
     * @param x
     * @param y
     */
    reset(x, y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 根据给定的点重置
     *
     * @param pt
     */
    resetByPoint(pt) {
        this.reset(pt.x, pt.y);
    }

    /**
     *
     * 是否是同一个点
     * @param pt
     */
    equal(pt) {
        return this.x === pt.x && this.y === pt.y;
    }

    /**
     * 偏移点
     *
     * @param x
     * @param y
     * @param clone 是否克隆一个
     */
    offset(x, y, clone) {
        if (!clone) {
            this.x += x;
            this.y += y;
        } else {
            return TPoint.Create(this.x + x, this.y + y);
        }
    }
}