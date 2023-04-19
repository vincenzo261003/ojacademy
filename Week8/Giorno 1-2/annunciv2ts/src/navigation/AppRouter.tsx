import { createBrowserRouter } from "react-router-dom";
import LayoutHome from "../pages/Home/Home";
import LayoutAuth from "../pages/Auth/AuthPage";
import LayoutAdDetail from "../pages/AdDetail/AdDetail";

export const router = createBrowserRouter([
    {
        path: "/",
        element: <LayoutHome />
    },
    {
        path: "/auth",
        element: <LayoutAuth />
    },
    {
        path: "/detail/:id",
        element: <LayoutAdDetail />
    }
]);