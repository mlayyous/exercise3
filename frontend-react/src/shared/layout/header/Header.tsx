import React, { PropsWithChildren } from 'react';
import './Header.css';

function Header({ children }: PropsWithChildren<{}>) {
  return (
    <header className="App-header">
      {children}
    </header>
  )
}

export default Header;
