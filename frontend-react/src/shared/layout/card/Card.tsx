import React, { PropsWithChildren } from 'react';
import './Card.css';

function Card({ title, subtitle, children }: PropsWithChildren<{ title: string, subtitle: string }>) {
  return (
    <div className="Card">
      <header className="Card-header">
        <h3 className="Card-title">{title}</h3>
        <h5 className="Card-subtitle">{subtitle}</h5>
      </header>
      {children}
    </div>
  )
}

export default Card;
