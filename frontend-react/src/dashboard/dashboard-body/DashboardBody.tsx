import React from 'react';
import DashboardCard from "../dashboard-card/DashboardCard";
import './DashboardBody.css'
import { ServiceSpend } from "../ServiceSpend";

function DashboardBody({ items }: { items: Array<ServiceSpend> }) {
  return (
    <div className="Dashboard-cards">
      {items.map(spending => <DashboardCard {...spending}/>)}
    </div>
  )
}

export default DashboardBody;
