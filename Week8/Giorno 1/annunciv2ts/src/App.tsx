import React from 'react';
import { RouterProvider } from 'react-router-dom';
import { router } from './navigation/AppRouter';
import { Navbar } from './components/shared/Navbar';

function App() {
  return (
    <>
      <RouterProvider router={router}/>
    </>
  );
}

export default App;
