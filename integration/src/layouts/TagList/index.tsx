import React from "react";
import "@styles/scss/layout/layout.scss";
import {Dropdown, MenuProps, Tag} from "antd";
import {useNavigate} from "react-router-dom";
import {Scrollbars} from "rc-scrollbars";
import {DownOutlined} from "@ant-design/icons";
const TagList: React.FC = ()=> {
    const navigation = useNavigate();
    const items: MenuProps['items'] = [
            {
                key: "2",
                label: "关闭其他标签"
            },
            {
                key: "3",
                label: "关闭全部标签"
            }
        ]

    return (
        <div className="tagsView-container dis-fl fd-r">
            <Scrollbars
                autoHide
                autoHideTimeout={1000}
                autoHideDuration={200}
                hideTracksWhenNotNeeded={true}
                renderView={props => <div {...props} className="scrollbar-container"/>}
                renderThumbVertical={props => <div {...props} className="scrollbar-track-vertical"/>}
            >
                <ul className="tags-wrap">

                </ul>
            </Scrollbars>
            <div style={{zIndex:100}}>
                <Dropdown menu={{items}} placement="bottomLeft">
                    <Tag className="mgr-16" color="error" style={{cursor: "pointer"}}>
                        关闭
                        <DownOutlined/>
                    </Tag>
                </Dropdown>
            </div>
        </div>
    )
}
export default TagList;