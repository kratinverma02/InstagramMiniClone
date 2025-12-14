from flask import Flask
from .extensions import db, jwt, migrate

def create_app():
    app = Flask(__name__)

    app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///instagram.db"
    app.config["JWT_SECRET_KEY"] = "secret-key"

    db.init_app(app)
    jwt.init_app(app)
    migrate.init_app(app, db)

    from .routes import (
        auth_routes, post_routes, like_routes,
        comment_routes, follow_routes, feed_routes
    )

    app.register_blueprint(auth_routes.auth_bp)
    app.register_blueprint(post_routes.post_bp)
    app.register_blueprint(like_routes.like_bp)
    app.register_blueprint(comment_routes.comment_bp)
    app.register_blueprint(follow_routes.follow_bp)
    app.register_blueprint(feed_routes.feed_bp)

    return app
