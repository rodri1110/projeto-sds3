import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import { RiLogoutBoxFill } from "react-icons/ri";

export const SidebarData = [
    {
        title: 'Perfil',
        path: "/perfil",
        icon: <AiIcons.AiFillHome />,
        cName: 'nav-text'
    },
    {
        title: 'Créditos',
        path: "/créditos",
        icon: <FaIcons.FaCartPlus />,
        cName: 'nav-text'
    },
    {
        title: 'Histórico',
        path: "/histórico",
        icon: <IoIcons.IoIosPaper />,
        cName: 'nav-text'
    },
    {
        title: 'Logout',
        path: "/logout",
        icon: <RiLogoutBoxFill  />,
        cName: 'nav-text'
    }

]

export default SidebarData;